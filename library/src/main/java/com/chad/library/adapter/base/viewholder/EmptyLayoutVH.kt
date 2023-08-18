package com.chad.library.adapter.base.viewholder

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * An emptyState viewHolder. (For internal use only)
 * 内部使用的空状态ViewHolder
 *
 * @property emptyLayout
 * @constructor Create empty Empty layout v h
 */
internal class EmptyLayoutVH(private val emptyLayout: FrameLayout) : RecyclerView.ViewHolder(emptyLayout) {

    fun changeEmptyView(view: View?) {
        if (view == null) return

        view.parent.run {
            if (this is ViewGroup) {
                this.removeView(view)
            }
        }

        if (view.layoutParams == null) {
            view.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER
            }
        }

        emptyLayout.removeAllViews()
        emptyLayout.addView(view)
    }
}
