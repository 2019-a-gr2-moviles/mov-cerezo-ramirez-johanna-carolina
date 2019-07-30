package com.example.examen1b

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class CarsMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var tienePermisosUbicacion = false
    private var markers = hashMapOf<String, Pair<Int, Int>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars_maps)
        solicitarPermisosUbicacion()
   
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        establecerConfiguracionMapa(mMap)



        Car.allCarsList.forEach {
           val lat = it.first.lat.toDouble()
           val lon = it.first.long.toDouble()
           val site = LatLng(lat,lon)
           val pair = Pair(searchIndex(it.first, it.second),it.second)
           anadirMarcador(site, "${it.first.modelName} de ${Driver.driversList[it.second].name}", pair)
        }


         mMap.setOnMarkerClickListener {
            var pair = markers.get(it.id)
                    //goToIngredientDetail(pair!!.first, pair!!.second)
                    goToCarDetail(pair!!.first, pair!!.second)
                    false
        }

    }


    fun goToCarDetail(position:Int, driverId:Int){
        val intent = Intent(
            this,
            CarsCrud :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("id", position)
        intent.putExtra("idDriver", driverId)
        startActivity(intent)
    }



    fun anadirMarcador(latLng : LatLng, title:String, pair: Pair<Int, Int>){
        var marker = mMap.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(title)
        )
        markers[marker.id] = pair
    }


    fun searchIndex(ingredient: Car, index : Int) : Int {
        var toReturn = -1
        Driver.driversList[index].hasCars.forEachIndexed { index, car ->
              if(car.id == ingredient.id){
                       toReturn = index
              }
        }
        return toReturn
    }




    fun establecerConfiguracionMapa(mapa : GoogleMap){
        val context = this.applicationContext
        with(mapa){

            val tienePermisos = ContextCompat
                .checkSelfPermission(
                    context,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            tienePermisosUbicacion = tienePermisos == PackageManager.PERMISSION_GRANTED
            if(tienePermisosUbicacion) {
                mapa.isMyLocationEnabled = true
            }
            this.uiSettings.isZoomControlsEnabled = true
            uiSettings.isMyLocationButtonEnabled = true
        }
    }

    fun solicitarPermisosUbicacion(){
        val tienePermisos = ContextCompat
            .checkSelfPermission(
                this.applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        this.tienePermisosUbicacion = tienePermisos == PackageManager.PERMISSION_GRANTED
        if(tienePermisosUbicacion){
            Log.i("mapa", "Tiene permisos")
        }else{
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1
            )
        }
    }
}
