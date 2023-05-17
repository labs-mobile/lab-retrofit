package prototype.todolist.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar")
    var avatar: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String
)