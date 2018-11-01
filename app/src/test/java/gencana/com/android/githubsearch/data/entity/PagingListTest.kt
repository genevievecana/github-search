package gencana.com.android.githubsearch.data.entity

import com.google.common.truth.Truth
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.UserModel
import org.junit.Test


class PagingListTest{

    private val user = UserData("gen", "a", 7.5)
    private val user1 = UserData("gen1", "b", 8.5)
    private val pagingList = PagingList(20, listOf(user, user1))

    @Test
    fun `paging data map`(){
        val pagingListModel: PagingListModel<UserModel> = pagingList.mapToPresentation {
            pagingList.data.map {
                it.mapToPresentation()
            }
        }

        Truth.assert_()
                .that(pagingList.totalCount)
                .isEqualTo(pagingListModel.totalCount)

        Truth.assert_()
                .that(pagingList.totalCount)
                .isEqualTo(20)

        Truth.assert_()
                .that(pagingList.data.size)
                .isEqualTo(pagingListModel.data.size)

        Truth.assert_()
                .that(pagingList.data.size)
                .isEqualTo(2)

        pagingList.data.forEachIndexed { index, userData ->
            Truth.assert_()
                    .that(userData.username)
                    .isEqualTo(pagingListModel.data[index].username)

            Truth.assert_()
                    .that(userData.avatarUrl)
                    .isEqualTo(pagingListModel.data[index].avatarUrl)

            Truth.assert_()
                    .that(userData.score)
                    .isEqualTo(pagingListModel.data[index].score)

        }
    }

}