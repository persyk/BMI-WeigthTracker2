package com.example.bmi_weigthtracker

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import com.android.volley.Header


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val rp = RequestParams()
        HttpUtils.post("http://5e2dbe3b3b0d640014be0ed3.mockapi.io/api/history", rp, object : JsonHttpResponseHandler() {
            fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject) {
                // If the response is JSONObject instead of expected JSONArray
                Log.d("asd", "---------------- this is response : $response")
                try {
                    val serverResp = JSONObject(response.toString())
                } catch (e: JSONException) {
                    // TODO Auto-generated catch block
                    e.printStackTrace()
                }

            }

            fun onSuccess(statusCode: Int, headers: Array<Header>, timeline: JSONArray) {
                // Pull out the first event on the public timeline

            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, History::class.java)
        this.startActivity(intent)
        return super.onOptionsItemSelected(item);

    }
}
