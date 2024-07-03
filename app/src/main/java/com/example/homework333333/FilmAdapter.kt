package com.example.homework333333

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

open class FilmAdapter : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>()  {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmAdapter.FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmAdapter.FilmViewHolder, position: Int) {
        val currentFilm = films[position]
        var filmname = currentFilm.name
        if(filmname.length > 15){
            filmname = filmname.substring(0, 15) + "..."
        }
        holder.filmTitle.text = filmname
        holder.yearTitle.text = currentFilm.year.toString()
        Picasso.get().load(currentFilm.cover).into(holder.filmImage)
        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(
                resId = R.id.action_firstFragment_to_filmFragment,
                args = FilmFragment.bundle(
                    currentFilm.name,
                    currentFilm.year.toString(),
                    currentFilm.cover,
                    currentFilm.description
                )
            )
        }
    }

    private val films: MutableList<Film> = mutableListOf(
        Film(
            "Interstellar",
            2014,
            "https://i.ebayimg.com/images/g/Gw0AAOSwcnxklKlS/s-l1200.webp",
            "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans."
        ),
        Film(
            "Joker",
            2019,
            "https://sobrosnetwork.com/wp-content/uploads/2023/10/joker-poster.jpg",
            "Arthur Fleck, a party clown and a failed stand-up comedian, leads an impoverished life with his ailing mother. However, when society shuns him and brands him as a freak, he decides to embrace the life of crime and chaos in Gotham City."
        ),
        Film(
            "The Godfather",
            1972,
            "https://i.ebayimg.com/images/g/x54AAOSwCzdklKmz/s-l1200.webp",
            "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son, Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger."
        ),
        Film(
            "Forrest Gump",
            1994,
            "https://wallpapers.com/images/hd/tom-hanks-quality-forrest-gump-poster-3kekahja8v9rsdms.jpg",
            "The history of the United States from the 1950s to the '70s unfolds from the perspective of an Alabama man with an IQ of 75, who yearns to be reunited with his childhood sweetheart."
        ),
        Film(
            "Truman Show",
            1998,
            "https://popcult.blog/wp-content/uploads/2022/01/truman-show-banner.png",
            "An insurance salesman discovers his whole life is actually a reality TV show."
        ),
        Film(
            "The Matrix",
            1999,
            "https://popcult.blog/wp-content/uploads/2021/12/matrix-banner.png?w=640",
            "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence."
        ),
        Film(
            "Toy Story",
            1995,
            "https://i0.wp.com/shatthemovies.com/wp-content/uploads/Toy-Story-1995-Movie-Poster-720x340.jpg",
            "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom."
        )
    ).toMutableList()

    override fun getItemCount(): Int {
        return films.size
    }

    inner class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filmTitle: TextView = itemView.findViewById(R.id.film_title)
        val yearTitle: TextView = itemView.findViewById(R.id.year_title)
        val filmImage: ImageView = itemView.findViewById(R.id.film_image)
    }

    open fun getFilms() = films

}