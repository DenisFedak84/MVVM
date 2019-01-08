package com.fedak.denis.mymvvm.fragment

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.fedak.denis.mymvvm.R
import com.fedak.denis.mymvvm.R.id.detailImageView
import com.fedak.denis.mymvvm.databinding.FragmentDetailBinding
import com.fedak.denis.mymvvm.handler.DetailFragmentHandler
import com.fedak.denis.mymvvm.model.Car
import com.fedak.denis.mymvvm.utils.DETAIL_ID
import com.fedak.denis.mymvvm.utils.DETAIL_TEXT
import com.fedak.denis.mymvvm.utils.DETAIL_URL
import com.fedak.denis.mymvvm.utils.toast
import com.fedak.denis.mymvvm.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_image_detail.*

class DetailFragment : BaseFragment(), DetailFragmentHandler {

    lateinit var binding: FragmentDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var id = arguments?.getInt(DETAIL_ID) ?: 0
        detailViewModel = getViewModel(this.activity!!, DetailViewModel::class.java)

        binding.model = detailViewModel
        binding.handler = this

        detailViewModel.loadCar(id)

        var error = detailViewModel.getError()

        error.observe(this, Observer { message ->
            activity?.toast(message!!)
        })
    }

    override fun onFragmentItemClick(view: View, car: Car) {
        when(view.id){
            R.id.detailImageView ->{

                val action = DetailFragmentDirections.actionDetailFragmentToDetailImageFragment()
                action.urlArg = car.thumbnailUrl
                findNavController(view).navigate(action)
            }
            R.id.detailTextView -> {

                val action = DetailFragmentDirections.actionDetailFragmentToDetailTextFragment()
                action.textArg = car.title
                findNavController(view).navigate(action)
            }
        }
    }
}