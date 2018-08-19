package it.t4group.androidsunflower.adapters

import android.databinding.BindingAdapter
import android.support.design.widget.FloatingActionButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import it.t4group.androidsunflower.R

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageURL: String?) {
    if (!imageURL.isNullOrBlank()) {
        Glide.with(view.context)
                .load(imageURL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
    }
}

@BindingAdapter("isGone")
fun bindIsGone(view: FloatingActionButton, isGone: Boolean?) {

    if (isGone == null || isGone)
        view.hide()
    else
        view.show()

}

@BindingAdapter("wateringText")
fun bindWateringText(textView: TextView, wateringInterval: Int) {

    val resources = textView.context.resources
    val quantityString = resources.getQuantityString(R.plurals.watering_needs_suffix,
            wateringInterval, wateringInterval)

    val bold = resources.getString(R.string.watering_needs_prefix)
    val finalString = "$bold $quantityString"

    textView.text = finalString
}