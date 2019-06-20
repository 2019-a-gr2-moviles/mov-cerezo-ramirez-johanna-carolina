package com.example.interfazmovil

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class StoryAdapter(private val storyList: ArrayList<Story>,
                   private val contexto: MainActivity,
                   private val recyclerView: RecyclerView
) : RecyclerView.Adapter<StoryAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var usernameTextView: TextView
        var numberFollowersTextView: TextView
        var userPhotoImageView:ImageView
        var userPhotoPostImageView:ImageView
        var likesNumberTextView:TextView
        var commentsNumberTextView:TextView
        var remixNumberTextView:TextView
        var descriptionTextView:TextView
        var likeBtn:ImageButton

        init {

            usernameTextView = view.findViewById(R.id.userNameLB) as TextView
            numberFollowersTextView = view.findViewById(R.id.followersNumberLB) as TextView
            userPhotoImageView = view.findViewById(R.id.userPhotoImage) as ImageView
            userPhotoPostImageView = view.findViewById(R.id.postImage) as ImageView
            likesNumberTextView = view.findViewById(R.id.numberLikesLB) as TextView
            commentsNumberTextView = view.findViewById(R.id.numberCommentsLB) as TextView
            remixNumberTextView = view.findViewById(R.id.numberRemixLB) as TextView
            descriptionTextView = view.findViewById(R.id.descriptionLB) as TextView
            likeBtn = view.findViewById(R.id.likeButton) as ImageButton


            likeBtn.setOnClickListener{
                when(usernameTextView.text){
                    "@jose" -> {
                        storyList[0].likesNumber += 1
                        storyList[0].liked = true
                    }

                    "@caro" -> {
                        storyList[1].likesNumber += 1
                        storyList[1].liked = true
                    }
                    "@paula" -> {
                        storyList[2].likesNumber += 1
                        storyList[2].liked = true
                    }
                    "@andres" -> {
                        storyList[3].likesNumber += 1
                        storyList[3].liked = true
                    }
                    }
                contexto.iniciarRecyclerView(storyList,contexto,recyclerView)
                likeBtn.setImageResource(R.mipmap.heartred)

            }








            /*val layout = view.findViewById(R.id.linear_layout) as LinearLayout

            layout
                .setOnClickListener {

                    Log.i("recycler-view", "Layout presionado")

                }*/

        }

    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    override fun onBindViewHolder(
        myViewHolder: StoryAdapter.MyViewHolder,
        position: Int
    ) {

        val story = storyList[position]

        myViewHolder.usernameTextView.text = story.username
        myViewHolder.numberFollowersTextView.text = story.numberFollowers.toString()
        myViewHolder.userPhotoImageView.setImageResource(story.userPhoto)
        myViewHolder.userPhotoPostImageView.setImageResource(story.userPhotoPost)
        myViewHolder.likesNumberTextView.text = story.likesNumber.toString()
        myViewHolder.commentsNumberTextView.text = story.commentsNumber.toString()
        myViewHolder.remixNumberTextView.text = story.remixNumber.toString()
        myViewHolder.descriptionTextView.text = story.description.toString()
        if(story.liked){
            myViewHolder.likeBtn.setImageResource(R.mipmap.heartred)
        }else{
            myViewHolder.likeBtn.setImageResource(R.mipmap.heart)
        }
    }

    // Esta funcion define el template que vamos a utilizar
    // El template esta en la carpeta de res/layout
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ):
            StoryAdapter.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.ly_story,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }



}

