package pt.tiago.computacaomovel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.recyclerline.view.*
import pt.tiago.computacaomovel.R
import pt.tiago.computacaomovel.dataclasses.Place


class LineAdapter(val list: ArrayList<Place>):RecyclerView.Adapter<LineAdapter.LineViewHolder>() {


    //Responsavel por criar cada uma das linhas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerline, parent, false);

        return LineViewHolder(itemView)
    }

    //Quantos itens vai ter
    override fun getItemCount(): Int {
        return list.size
    }

    //Faz a junção do que vem da lista com o que está no ficheiro do layout
    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
        val currentPlace = list[position]

        holder.name.text = currentPlace.name
        holder.capital.text = currentPlace.capital
        holder.nhabitants.text = currentPlace.habitants.toString()

    }
    //Representa o conteudo da linha
    class LineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.name
        val capital = itemView.capital
        var nhabitants = itemView.habitants
    }


}