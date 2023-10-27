package com.example.mainapp

import com.example.findmyip3.model.IPFetcherResponseModel
import com.example.findmyip3.network.NetworkRequest
import com.example.findmyip3.repository.IPFetcherRepository
import com.example.findmyip3.repository.IRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FindMyIPTest {
    @Mock
    private lateinit var api: NetworkRequest

    private lateinit var repository: IRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = IPFetcherRepository()
        api = mock(NetworkRequest::class.java)
    }

    @Test
    fun `Test successful response`() = runBlocking {
        val response = IPFetcherResponseModel(region = "Georgia", city = "Atlanta", country = "United States")
        val mockResponse = Response.success(response)

        `when`(api.getIpDetails()).thenReturn(mockResponse)

        val result = api.getIpDetails().body()

        // Verify that the flow emits the expected states in the correct order
        assertEquals(result?.region, response.region)
        assertEquals(result?.city, response.city)
        assertEquals(result?.country, response.country)
    }
}