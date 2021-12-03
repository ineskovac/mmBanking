package hr.asseco.mbanking.models

data class Users(
    val user : UserModelClass
)

data class UserModelClass (
    val user_id : Int,
    val acounts : List<Accounts>
)

data class Accounts(
    val id : Int,
    val iBAN : String,
    val amount : String,
    val currency : String,
    val transactions : List<Transactions>
)

data class Transactions(
    val id : Int,
    val date : String,
    val description : String,
    val amount : String,
    val type : String
)