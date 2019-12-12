package com.example.listahome



    import android.content.ContentValues
    import android.content.Context
    import android.database.Cursor
    import android.database.sqlite.SQLiteDatabase
    import android.database.sqlite.SQLiteOpenHelper
    import android.util.Log

    class DatabaseUsuario(context: Context) : SQLiteOpenHelper(context, "aula.db", null, 1) {

        companion object {

            const val TAG = "DatabaseUsuario"
            const val TABLE = "Usuario"
            const val LOGIN: String = "Login"
            const val CPF: String = "CPF"
            const val EMAIL: String = "Email"
            const val SENHA: String = "Senha"
        }

//        val DATABASE_CREATE =
//            "CREATE TABLE if not exists " + TABLE + " (" +
//                    "${CPF} integer PRIMARY KEY autoincrement," +
//                    "${LOGIN} text," +
//                    "${EMAIL} text,"+
//                    "${SENHA} text"+
//                    ")"


        val DATABASE_CREATE =
            "CREATE TABLE if not exists " + TABLE + " (" +
                    "${CPF} text," +
                    "${LOGIN} text," +
                    "${EMAIL} text,"+
                    "${SENHA} text"+
                    ")"

        fun insertLog(user: User) {
            val values = ContentValues()
            values.put(CPF, user.cpf)
            values.put(LOGIN, user.login)
            values.put(EMAIL, user.email)
            values.put(SENHA, user.senha)
            writableDatabase.insert(TABLE, null, values);
        }


        fun getLogs(): Cursor {
            return readableDatabase
                .query(TABLE, arrayOf(CPF, LOGIN, EMAIL, SENHA), null, null, null, null, null);
        }

        fun getLog(login: String) : Cursor {
            return getReadableDatabase()
                .query(TABLE, arrayOf(CPF, LOGIN, EMAIL, SENHA), "${LOGIN}='${login}'", null, null, null, null)
        }

//

        override fun onCreate(db: SQLiteDatabase?) {
            Log.d("MyDatabase", "Creating: $DATABASE_CREATE")
            db?.execSQL(DATABASE_CREATE)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL("DROP TABLE IF EXISTS" + TABLE);
            onCreate(db);
        }
    }