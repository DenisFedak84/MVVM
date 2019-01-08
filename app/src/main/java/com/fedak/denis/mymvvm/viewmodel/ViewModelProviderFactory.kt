package com.fedak.denis.mymvvm.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

//open class ViewModelProviderFactory @Inject constructor(creators: Map<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {
//
//    var creators: Map<Class<out ViewModel>, Provider<ViewModel>>? = null
//
//    init {
//        this.creators = creators
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//
//        var creator: Provider<out ViewModel>? = creators!![modelClass]
//
//
//        if (creator == null) {
//            for ((key, value) in creators!!) {
//                if (modelClass.isAssignableFrom(key)) {
//                    creator = value
//                    break
//                }
//            }
//        }
//
//        if (creator == null) {
//            throw IllegalArgumentException("unknown model class $modelClass")
//        }
//        try {
//            return creator.get() as T
//        } catch (e: Exception) {
//            throw RuntimeException(e)
//        }
//
//    }
//}

class ViewModelProviderFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?:
        creators.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
        ?: throw IllegalArgumentException("unknown model class " + modelClass)

        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}