package com.fehosdsg7.dagger2.di

import androidx.lifecycle.ViewModel
import com.fehosdsg7.dagger2.data.MockData
import com.fehosdsg7.dagger2.domain.IteratorClass
import com.fehosdsg7.dagger2.presentation.MainViewModel
import com.fehosdsg7.dagger2.presentation.utils.MultiViewModelFactory
import com.fehosdsg7.dagger2.presentation.utils.ViewModelKey
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Inject

@Component(modules = [AppModule::class, ViewModelModel::class])
interface AppComponent{
    fun viewModelFactory() : MultiViewModelFactory
}

@Module
class AppModule {
    @Provides
    fun providesInteractor(mockData: MockData) : IteratorClass {
        return IteratorClass(mockData)
    }
    @Provides
    fun provideRepositore() : MockData {
        return MockData()
    }
}
@Module
interface ViewModelModel{
    @Binds
    @[IntoMap ViewModelKey(MainViewModelData::class)]
    fun provideMainViewModelData(mainViewModelData: MainViewModelData) : ViewModel

    @Binds
    @[IntoMap ViewModelKey(SecondViewModelData::class)]
    fun provideSecondViewModelData(secondViewModelData: SecondViewModelData) : ViewModel

    @Binds
    @[IntoMap ViewModelKey(MainViewModel::class)]
    fun provideMainViewModel(secondViewModelData: MainViewModel) : ViewModel
}

class MainViewModelData  @Inject constructor() : ViewModel()
class SecondViewModelData  @Inject constructor() : ViewModel()
