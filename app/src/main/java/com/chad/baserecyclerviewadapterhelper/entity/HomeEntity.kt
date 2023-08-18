package com.chad.baserecyclerviewadapterhelper.entity

/**
 * @author: limuyang
 * @date: 2019-12-06
 * @Description:
 */
data class HomeEntity(
    val name: String = "",
    val activity: Class<*>? = null,
    val imageResource: Int = 0,
    val sectionTitle: String = ""
) {
    val isSection: Boolean
        get() = sectionTitle.isNotBlank()
}