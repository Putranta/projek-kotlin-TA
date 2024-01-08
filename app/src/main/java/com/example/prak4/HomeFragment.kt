package com.example.prak4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CategoryAdapter
    lateinit var ItemRV : RecyclerView
    lateinit var ItemAdapter : ItemHomeAdapter

    private val list = ArrayList<PostResponseDataClass>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        init(rootView)
        initItem(rootView)
        return rootView
    }

    private fun initItem(rootView: View) {
        ItemRV = rootView.findViewById(R.id.ItemHomeRecyclerView)

        ItemRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        RetrofitClient.instance.getPosts().enqueue(object: Callback<ArrayList<PostResponseDataClass>>{
            override fun onResponse(
                call: Call<ArrayList<PostResponseDataClass>>,
                response: Response<ArrayList<PostResponseDataClass>>
            ) {
                response.body()?.let { list.addAll(it) }
                activity?.runOnUiThread {
                    val adapter2 = PostAdapter(list)
                    ItemRV.adapter = adapter2
                    adapter2.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ArrayList<PostResponseDataClass>>, t: Throwable) {

            }

        })

    }

    private fun init(rootView: View) {
        recyclerView = rootView.findViewById(R.id.CategoryRecyclerView)

        val data = ArrayList<CategoryDataClass>()
        data.add(CategoryDataClass(R.drawable.clothes, "Pakaian"))
        data.add(CategoryDataClass(R.drawable.television, "Elektronik"))
        data.add(CategoryDataClass(R.drawable.bmx, "Sepeda"))
        data.add(CategoryDataClass(R.drawable.sneakers, "Sepatu"))
        adapter = CategoryAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }
}
