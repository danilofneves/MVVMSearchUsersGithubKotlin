package com.github.repositories.ui.home.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.repositories.data.Resource
import com.github.repositories.data.model.User
import com.github.repositories.databinding.FragmentUserlistBinding
import com.github.repositories.ui.home.view.adapter.UserListAdapter
import com.github.repositories.ui.home.viewmodel.HomeViewModel
import com.github.repositories.util.ViewModelFactory
import javax.inject.Inject
import dagger.android.support.DaggerFragment

class  HomeFragment: DaggerFragment() {

    private lateinit var binding: FragmentUserlistBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var homeViewModel: HomeViewModel

    private lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        binding = FragmentUserlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            val handler = Handler(Looper.getMainLooper())
            var workRunnable: Runnable ?= null
            override fun afterTextChanged(s: Editable) {
                handler.removeCallbacks(workRunnable)
                workRunnable = Runnable { homeViewModel.searchUsers(s.toString())}
                handler.postDelayed(workRunnable, 500)
            }
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })

        observeViewModel()
    }

    private fun initRecyclerView(users: List<User>){
        userListAdapter = UserListAdapter()
        binding.ltvUsers.adapter = userListAdapter
        userListAdapter.submitList(users)
    }

    private fun handleUserList(status: Resource<List<User>>) {
        when (status) {
            is Resource.Loading -> binding.vflipper.displayedChild = 2
            is Resource.Success -> status.data?.let {
                binding.vflipper.displayedChild = 1
                initRecyclerView(users = it)
            }
            is Resource.DataError -> {binding.vflipper.displayedChild = 3}
        }
    }

    private fun observeViewModel() {
        homeViewModel.usersLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                t -> handleUserList(t)
            }
        })
    }


}