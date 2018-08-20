package it.t4group.androidsunflower

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.t4group.androidsunflower.adapters.PlantAdapter
import it.t4group.androidsunflower.utilities.InjectorUtils
import it.t4group.androidsunflower.viewmodels.PlantListViewModel

class PlantListFragment : Fragment() {

    private lateinit var viewModel: PlantListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_plant_list, container, false)
        val context = context ?: return view

        val factory = InjectorUtils.providePlantListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(PlantListViewModel::class.java)


        val adapter = PlantAdapter()
        with(view.findViewById<RecyclerView>(R.id.plant_list)) {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
        subscribeUi(adapter)

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_plant_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.filter_zone -> {
                updateData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun subscribeUi(adapter: PlantAdapter) {
        viewModel.getPlants().observe(viewLifecycleOwner, Observer {
            if (it != null)
                adapter.submitList(it)
        })
    }

    private fun updateData() {
        with(viewModel) {
            if (isFiltered())
                clearGrowZoneNumber()
            else
                setGrowZoneNumber(9)
        }
    }

}