package com.carevalo.valid_app;

import com.carevalo.valid_app.network.ApiAdapter;
import com.carevalo.valid_app.network.ApiService;
import com.carevalo.valid_app.network.response.ArtistResponse;
import com.carevalo.valid_app.ui.artist.ArtistUseCase;
import com.carevalo.valid_app.utils.AnnotationNetwork;

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {

    private ApiService apiService;
    private ArtistUseCase artistUseCase;

    Properties prop;

    private static String COUNTRY = "country";
    private static String API_KEY = "api_key";
    private static String API_FORMAT = "api_format";

    @Before
    public void setUp(){
        apiService = ApiAdapter.createService(ApiService.class);
        prop = new Properties();
    }

    @Test
    public void getArtists() throws Exception{

        final MutableLiveData<ArtistResponse> artistsData = new MutableLiveData<>();
        apiService.getArtists(AnnotationNetwork.ARTIST_METHOD, prop.getProperty(COUNTRY),
                prop.getProperty(API_KEY), prop.getProperty(API_FORMAT))
                .enqueue(new Callback<ArtistResponse>() {
                    @Override
                    public void onResponse(Call<ArtistResponse> call, Response<ArtistResponse> response) {
                        if (response.isSuccessful()){
                            artistsData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArtistResponse> call, Throwable t) {
                        artistsData.setValue(null);
                    }
                });

        assertNotNull(artistsData);

    }

    @Test
    public void getArtistsFromVM() throws Exception{
        MutableLiveData<ArtistResponse> mutableLiveData;

        artistUseCase = ArtistUseCase.getInstance();
        mutableLiveData = artistUseCase.getArtists();

        assertNotNull(mutableLiveData);
    }
}