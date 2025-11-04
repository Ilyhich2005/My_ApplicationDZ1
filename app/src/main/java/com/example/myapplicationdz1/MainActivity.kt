package com.example.myapplicationdz1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplicationdz1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binder: ActivityMainBinding
    private val addapter = MyAddapter()
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)
        init()
    }

    private fun init(){
        val spanCount = resources.getInteger(R.integer.span_count)
        binder.myRecView.layoutManager = GridLayoutManager(this,spanCount)
        binder.myRecView.adapter = addapter
        addapter.setItems(viewModel.item_list)
        binder.addButton.setOnClickListener {
            lateinit var item:Item
            if (viewModel.number%2==1){
                item = Item(viewModel.number,R.color.myblue)
            }
            else{
                Log.d("mine","red")
                item = Item(viewModel.number,R.color.myred)
            }
            addapter.add_item(item)
            viewModel.item_list.add(item)
            viewModel.number+=1
        }
    }

}