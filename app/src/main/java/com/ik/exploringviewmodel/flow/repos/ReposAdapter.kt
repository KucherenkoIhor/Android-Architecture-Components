package com.ik.exploringviewmodel.flow.repos

import android.view.View
import android.widget.TextView
import com.ik.exploringviewmodel.R
import com.ik.exploringviewmodel.base.BaseAdapter
import com.ik.exploringviewmodel.base.BaseViewHolder
import com.ik.exploringviewmodel.entities.Repo

/**
 * Created by ihor on 19.05.17.
 */
class ReposAdapter : BaseAdapter<Repo, ReposAdapter.ReposViewHolder>() {

    override fun getItemViewId(): Int = R.layout.view_item

    override fun instantiateViewHolder(view: View?): ReposViewHolder = ReposViewHolder(view)

    class ReposViewHolder(itemView: View?) : BaseViewHolder<Repo>(itemView) {

        val tvName : TextView by lazy { itemView?.findViewById(R.id.tvName) as TextView }
        val tvDescription : TextView by lazy { itemView?.findViewById(R.id.tvDescription) as TextView }

        override fun onBind(item: Repo) {
            tvName.text = item.name
            tvDescription.text = item.description
        }

    }

}