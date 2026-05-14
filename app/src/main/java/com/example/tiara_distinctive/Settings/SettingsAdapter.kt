package com.example.tiara_distinctive.Settings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.tiara_distinctive.databinding.ItemSettingsBinding


class SettingsAdapter (
    context: Context,
    private val settingsList: List<SettingsModel>
    ) : ArrayAdapter<SettingsModel>(context, 0, settingsList) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            val binding = ItemSettingsBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )

            val data = settingsList[position]

            binding.textTitle.text = data.title

            return binding.root
        }
    }
