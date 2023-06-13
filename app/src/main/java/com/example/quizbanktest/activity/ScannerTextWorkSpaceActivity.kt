package com.example.quizbanktest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.introducemyself.utils.ConstantsOcrResults
import com.example.quizbanktest.R
import com.example.quizbanktest.adapters.OcrResultViewAdapter
import com.example.quizbanktest.models.OcrResultModel

class ScannerTextWorkSpaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner_text_work_space)
        setupOcrRecyclerView(ConstantsOcrResults.getQuestions())
    }
    private fun setupOcrRecyclerView(ocrResultList: ArrayList<OcrResultModel>) {
        var ocrList : androidx.recyclerview.widget.RecyclerView = findViewById(R.id.ocr_list)
        ocrList?.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        ocrList?.setHasFixedSize(true)

        val placesAdapter = OcrResultViewAdapter(this, ocrResultList)
        ocrList?.adapter = placesAdapter

    }
}