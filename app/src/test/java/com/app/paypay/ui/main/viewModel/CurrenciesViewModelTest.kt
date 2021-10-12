package com.app.paypay.ui.main.viewModel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.app.paypay.data.api.ApiHelper
import com.app.paypay.data.local.DatabaseHelper
import com.app.paypay.data.repository.MainRepository
import com.app.paypay.util.TestCoroutineRule
import com.app.paypay.utils.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CurrenciesViewModelTest  {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var apiHelper: ApiHelper

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var context: Context


    @Mock
    private lateinit var databaseHelper: DatabaseHelper

    @Mock
    private lateinit var apiUsersObserver: Observer<Resource<Map<String, Double>>>

    @Before
    fun setUp() {
        // do something if required
    }

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(mapOf<String,Double>())
                .`when`(mainRepository).getCurrencies()
            val viewModel = CurrenciesViewModel(mainRepository,databaseHelper)
            viewModel.getCurrencies().observeForever(apiUsersObserver)
            verify(apiHelper).getCurrency()
            verify(apiUsersObserver).onChanged(Resource.success(mapOf()))
            viewModel.getCurrencies().removeObserver(apiUsersObserver)
        }
    }

    @Test
    fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            doThrow(RuntimeException(errorMessage))
                .`when`(mainRepository).getCurrencies()
            val viewModel = CurrenciesViewModel( mainRepository,databaseHelper)
            viewModel.getCurrencies().observeForever(apiUsersObserver)
            verify(apiHelper).getCurrency()
            verify(apiUsersObserver).onChanged(
                Resource.error(
                    RuntimeException(errorMessage).toString(),
                    null
                )
            )
            viewModel.getCurrencies().removeObserver(apiUsersObserver)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }



}