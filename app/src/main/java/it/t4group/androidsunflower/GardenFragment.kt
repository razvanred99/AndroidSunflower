package it.t4group.androidsunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.t4group.androidsunflower.adapters.GardenPlantingAdapter
import it.t4group.androidsunflower.utilities.InjectorUtils
import it.t4group.androidsunflower.viewmodels.GardenPlantingListViewModel

class GardenFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_garden, container, false)
        val adapter = GardenPlantingAdapter()
        with(view.findViewById<RecyclerView>(R.id.garden_list)) {
            layoutManager = LinearLayoutManager(view.context)
            this.adapter = adapter
        }

        return view
    }

    private fun subscribeUi(adapter: GardenPlantingAdapter) {
        val factory = InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext())
        val viewModel = ViewModelProviders.of(this, factory).get(GardenPlantingListViewModel::class.java)

        viewModel.gardenPlantings.observe(viewLifecycleOwner, Observer {
            if (it != null && it.isNotEmpty()) {
                activity?.run {
                    findViewById<RecyclerView>(R.id.garden_list).run {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.txvEmptyGarden).run {
                        visibility = View.GONE
                    }
                }
            } else {
                activity?.run {
                    findViewById<RecyclerView>(R.id.garden_list).run {
                        visibility = View.GONE
                    }
                    findViewById<TextView>(R.id.txvEmptyGarden).run {
                        visibility = View.VISIBLE
                    }
                }
            }
        })

        viewModel.plantAndGardenPlantings.observe(this, Observer {
            if (it != null && it.isNotEmpty())
                adapter.submitList(it)
        })
    }

}