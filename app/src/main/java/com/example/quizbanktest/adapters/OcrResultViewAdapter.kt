package com.example.quizbanktest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizbanktest.R

import com.example.quizbanktest.models.OcrResultModel


class OcrResultViewAdapter(
    private val context: Context,
    private var list: ArrayList<OcrResultModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_scanner_text,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]
        if (holder is MyViewHolder) {

            holder.itemView.findViewById<co.lujun.androidtagview.TagContainerLayout>(R.id.scannerTagForBank).tags = model.bankList
            holder.itemView.findViewById<co.lujun.androidtagview.TagContainerLayout>(R.id.scannerTagForQuestion).tags = model.questionList
            holder.itemView.findViewById<co.lujun.androidtagview.TagContainerLayout>(R.id.scannerTagForRange).tags = model.rangList

            holder.itemView.setOnClickListener {

                if (onClickListener != null) {
                    onClickListener!!.onClick(position, model)
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }



    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: OcrResultModel)
    }

    private class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}