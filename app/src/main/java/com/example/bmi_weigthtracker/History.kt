package com.example.bmi_weigthtracker

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL

class History : AppCompatActivity() {

    var dataList = ArrayList<HashMap<String, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchJsonData().execute()
    }


    inner class fetchJsonData() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: String?): String? {
            return URL("http://5e2dbe3b3b0d640014be0ed3.mockapi.io/api/history").readText(
                Charsets.UTF_8
            )
        }
        override fun onPostExecute(result: String?) {

            super.onPostExecute(result)

           findViewById<ProgressBar>(R.id.loader).visibility = View.GONE

            val jsonObj = JSONObject(result)
            val usersArr = jsonObj.getJSONArray("data")
            for (i in 0 until usersArr.length()) {
                val singleUser = usersArr.getJSONObject(i)

                val map = HashMap<String, String>()
                map["id"] = singleUser.getString("id")
                map["height"] = singleUser.getString("height")
                map["weight"] = singleUser.getString("weight")
                map["bmi"] = singleUser.getString("bmi")
                map["date"] = singleUser.getString("date")
                dataList.add(map)
            }

            findViewById<ListView>(R.id.listView).adapter = Utils(this@History, dataList)
        }
    }
}
