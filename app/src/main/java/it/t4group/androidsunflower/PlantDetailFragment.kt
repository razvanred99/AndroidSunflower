package it.t4group.androidsunflower

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import it.t4group.androidsunflower.databinding.FragmentPlantDetailBinding
import it.t4group.androidsunflower.utilities.InjectorUtils
import it.t4group.androidsunflower.viewmodels.PlantDetailViewModel

class PlantDetailFragment : Fragment() {

    private lateinit var shareText: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val plantID = PlantDetailFragmentArgs.fromBundle(arguments).plantId
        val factory = InjectorUtils.providePlantDetailViewModelFactory(requireActivity(), plantID)
        val plantDetailViewModel = ViewModelProviders.of(this, factory).get(PlantDetailViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(inflater, R.layout.fragment_plant_detail, container, false).apply {

            viewModel = plantDetailViewModel
            setLifecycleOwner(this@PlantDetailFragment)
            fab.setOnClickListener {
                plantDetailViewModel.addPlantToGarden()
                Snackbar.make(it, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show()
            }

        }

        plantDetailViewModel.plant.observe(this, Observer {
            shareText = if (it == null) "" else getString(R.string.share_text_plant, it.name)
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_share -> {
                val shareIntent = ShareCompat.IntentBuilder.from(activity)
                        .setText(shareText)
                        .setType("text/plain")
                        .createChooserIntent()
                        .apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                        }
                startActivity(shareIntent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}