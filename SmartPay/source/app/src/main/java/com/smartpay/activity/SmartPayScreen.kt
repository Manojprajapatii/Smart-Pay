package com.smartpay.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.MobileAds
import com.smartpay.R
import com.smartpay.adapter.BusinessesAdapter
import com.smartpay.databinding.ActivitySmartPayScreenBinding
import com.smartpay.model.Businesses
import com.smartpay.model.User

class SmartPayScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySmartPayScreenBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var userList: MutableList<User>
    private lateinit var businessesAdapter: BusinessesAdapter
    private lateinit var businessesList: MutableList<Businesses>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmartPayScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) { initializationStatus ->
            // Handle initialization status here.
            // For example, you can log the status or perform actions based on success/failure.
            Log.d("MobileAds", "Initialization complete: $initializationStatus")
        }

        binding.profileImage.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val searchContainer: View = findViewById(R.id.searchContainer)
        val searchEditText: EditText = findViewById(R.id.searchEditText)

        searchContainer.setOnClickListener {
            searchEditText.isFocusableInTouchMode = true
            searchEditText.isFocusable = true
            searchEditText.requestFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(searchEditText, InputMethodManager.SHOW_IMPLICIT)
        }

        userList = mutableListOf(
            User("Tarun Mand", R.drawable.user2),
            User("Ujwal Mane", R.drawable.user3),
            User("Radhika Meka", R.drawable.user1),
            User("Yasmin Mukhopadhyay", R.drawable.user7),
            User("Bimla Virk", R.drawable.user8),
            User("Rosey Raval", R.drawable.user9),
            User("Bahadur Sachar", R.drawable.user10),
            User("More", R.drawable.more),
            User("Prabhat Jaggi", R.drawable.user3),
            User("Chand Varughese", R.drawable.user5),
            User("Abbas Pardeshi", R.drawable.user1),
            User("Judy Berg", R.drawable.user5),
            User("Corine Mann", R.drawable.user10),
            User("Less", R.drawable.less)
        )

        businessesList = mutableListOf(
            Businesses("Manoj prajapat", R.drawable.mnoj),
            Businesses("Yasmin Mukhopadhyay", R.drawable.user7),
            Businesses("Jio", R.drawable.jio_logo_icon),
            Businesses("More", R.drawable.more),
            Businesses("BSNL", R.drawable.bsnl),
            Businesses("Yasmin Mukhopadhyay", R.drawable.user7),
            Businesses("Bimla Virk", R.drawable.user8),
            Businesses("Rosey Raval", R.drawable.user9),
            Businesses("Bahadur Sachar", R.drawable.user10),
            Businesses("Prabhat Jaggi", R.drawable.user3),
            Businesses("Chand Varughese", R.drawable.user5),
            Businesses("Abbas Pardeshi", R.drawable.user1),
            Businesses("Judy Berg", R.drawable.user5),
            Businesses("Less", R.drawable.less)
        )



        userAdapter = UserAdapter(userList)
        val userLayoutManager = GridLayoutManager(this, 4)
        binding.recyclerView.layoutManager = userLayoutManager
        binding.recyclerView.adapter = userAdapter

        businessesAdapter = BusinessesAdapter(businessesList)
        val businessLayoutManager = GridLayoutManager(this, 4)
        binding.recyclerView2.layoutManager = businessLayoutManager
        binding.recyclerView2.adapter = businessesAdapter
    }
//    fun openKeyboardOnClick(view: View) {
//        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.showSoftInput(view, InputMethodManager.RESULT_UNCHANGED_SHOWN)
//    }

//    fun openKeyboardOnClick(view: View) {
//        val searchEditText: EditText = findViewById(R.id.searchEditText)
//        searchEditText.isFocusableInTouchMode = true
//        searchEditText.isFocusable = true
//        searchEditText.requestFocus()
//
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.showSoftInput(searchEditText, InputMethodManager.SHOW_IMPLICIT)
//    }



}
