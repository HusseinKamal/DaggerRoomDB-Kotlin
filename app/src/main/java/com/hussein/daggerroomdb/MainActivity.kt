package com.hussein.daggerroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hussein.daggerroomdb.database.UserEntity
import com.hussein.daggerroomdb.databinding.ActivityMainBinding
import com.hussein.daggerroomdb.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        initViewModel()

        binding.btnSave.setOnClickListener{
            val user=UserEntity(name = binding.edtDesc.text.toString())
            mainViewModel.insertRecord(user)
            binding.tvResult.text=""
        }
    }

    private fun initViewModel(){
        //Lambda format
        mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.getRecordsObservers().observe(this) { t ->
            binding.tvResult.text = ""
            t?.forEach {
                binding.tvResult.append(it.name + "\n")
            }
        }
        //Original format
        /*mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]
         mainViewModel.getRecordsObservers().observe(this, object : Observer<List<UserEntity>> {
             override fun onChanged(t: List<UserEntity>?) {
                 binding.tvResult.text=""
                 t?.forEach{
                     binding.tvResult.append(it.name+"\n")
                 }
             }
         })*/
    }
}