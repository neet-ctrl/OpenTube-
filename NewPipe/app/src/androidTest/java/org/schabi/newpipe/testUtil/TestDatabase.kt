package org.schabi.opentube.testUtil

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertSame
import org.schabi.opentube.OpenTubeDatabase
import org.schabi.opentube.database.AppDatabase

class TestDatabase {
    companion object {
        fun createReplacingOpenTubeDatabase(): AppDatabase {
            val database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                AppDatabase::class.java
            )
                .allowMainThreadQueries()
                .build()

            val databaseField = OpenTubeDatabase::class.java.getDeclaredField("databaseInstance")
            databaseField.isAccessible = true
            databaseField.set(OpenTubeDatabase::class, database)

            assertSame(
                "Mocking database failed!",
                database,
                OpenTubeDatabase.getInstance(ApplicationProvider.getApplicationContext())
            )

            return database
        }
    }
}
