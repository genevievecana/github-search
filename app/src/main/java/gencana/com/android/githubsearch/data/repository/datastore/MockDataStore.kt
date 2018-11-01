package gencana.com.android.githubsearch.data.repository.datastore

import com.squareup.moshi.Moshi
import gencana.com.android.githubsearch.data.entity.PagingList
import gencana.com.android.githubsearch.data.entity.UserData
import gencana.com.android.githubsearch.data.local.getSampleUserList
import io.reactivex.Single

class MockDataStore(private val moshi: Moshi): UserDataStore{

    override fun searchUsers(query: String, page: Int): Single<PagingList<UserData>>
            = Single.just(getSampleUserList(moshi))

}