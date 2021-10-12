package com.app.paypay.ui.main.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.paypay.R
import com.app.paypay.data.model.CountryListResponseModel
import com.app.paypay.ui.view.ExchnageFormActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.row_item.*
import kotlinx.android.synthetic.main.row_item.view.*
import java.io.IOException
import java.io.InputStream


class CurrencyListAdapter(
    private var currencies: Map<String,Double>
) : RecyclerView.Adapter<CurrencyListAdapter.DataViewHolder>() {




    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(countryCurrencyCode:String,amount : Double) {
            itemView.description.text = countryCurrencyCode
            itemView.name.text = "$amount"
            itemView.icon.text = countryCurrencyCode.substring(0,1)
            itemView.container.setOnClickListener {
                val intent = Intent(it.context, ExchnageFormActivity::class.java)
                val bundle = Bundle()
                bundle.putString("countryCode",countryCurrencyCode)
                bundle.putDouble("amount",amount)
                intent.putExtras(bundle)
                it.context.startActivity(intent)
            }

        }

        fun inputStreamToString(inputStream: InputStream): String? {
            return try {
                val bytes = ByteArray(inputStream.available())
                inputStream.read(bytes, 0, bytes.size)
                String(bytes)
            } catch (e: IOException) {
                null
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item, parent,
                false
            )
        )

    override fun getItemCount(): Int = currencies.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(ArrayList(currencies.keys)[position].substring(3), ArrayList(currencies.values)[position])
    }

  // fun addData(list: Map<String,Double>) = toMap().apply { put(key, value) }
    fun addData(list: Map<String,Double>) {
        currencies += list;
    }




}