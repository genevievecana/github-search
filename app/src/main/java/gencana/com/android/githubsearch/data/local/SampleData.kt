package gencana.com.android.githubsearch.data.local

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import gencana.com.android.githubsearch.data.entity.PagingList
import gencana.com.android.githubsearch.data.entity.UserData


fun getSampleUserList(moshi: Moshi): PagingList<UserData>?{
    val listType = Types.newParameterizedType(PagingList::class.java, UserData::class.java)
    val adapter: JsonAdapter<PagingList<UserData>> = moshi.adapter(listType)
    return adapter.fromJson(userListData)
}


val userListData = """
    {
  "total_count": 145,
  "incomplete_results": false,
  "items": [
    {
      "login": "gentwolf-shen",
      "id": 19789401,
      "avatar_url": "https://avatars0.githubusercontent.com/u/34187?v=4",
      "following_url": "https://api.github.com/users/gentwolf-shen/following{/other_user}",
      "gists_url": "https://api.github.com/users/gentwolf-shen/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/gentwolf-shen/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/gentwolf-shen/subscriptions",
      "organizations_url": "https://api.github.com/users/gentwolf-shen/orgs",
      "repos_url": "https://api.github.com/users/gentwolf-shen/repos",
      "events_url": "https://api.github.com/users/gentwolf-shen/events{/privacy}",
      "received_events_url": "https://api.github.com/users/gentwolf-shen/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.584698
    },
    {
      "login": "genievn",
      "id": 34187,
      "node_id": "MDQ6VXNlcjM0MTg3",
      "avatar_url": "https://avatars0.githubusercontent.com/u/34187?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/genievn",
      "html_url": "https://github.com/genievn",
      "followers_url": "https://api.github.com/users/genievn/followers",
      "following_url": "https://api.github.com/users/genievn/following{/other_user}",
      "gists_url": "https://api.github.com/users/genievn/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/genievn/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/genievn/subscriptions",
      "organizations_url": "https://api.github.com/users/genievn/orgs",
      "repos_url": "https://api.github.com/users/genievn/repos",
      "events_url": "https://api.github.com/users/genievn/events{/privacy}",
      "received_events_url": "https://api.github.com/users/genievn/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.58268
    },
    {
      "login": "jonicong",
      "id": 1884176,
      "node_id": "MDQ6VXNlcjE4ODQxNzY=",
      "avatar_url": "https://avatars1.githubusercontent.com/u/1884176?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/jonicong",
      "html_url": "https://github.com/jonicong",
      "followers_url": "https://api.github.com/users/jonicong/followers",
      "following_url": "https://api.github.com/users/jonicong/following{/other_user}",
      "gists_url": "https://api.github.com/users/jonicong/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/jonicong/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/jonicong/subscriptions",
      "organizations_url": "https://api.github.com/users/jonicong/orgs",
      "repos_url": "https://api.github.com/users/jonicong/repos",
      "events_url": "https://api.github.com/users/jonicong/events{/privacy}",
      "received_events_url": "https://api.github.com/users/jonicong/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.54091
    },
    {
      "login": "genpfault",
      "id": 721338,
      "node_id": "MDQ6VXNlcjcyMTMzOA==",
      "avatar_url": "https://avatars0.githubusercontent.com/u/721338?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/genpfault",
      "html_url": "https://github.com/genpfault",
      "followers_url": "https://api.github.com/users/genpfault/followers",
      "following_url": "https://api.github.com/users/genpfault/following{/other_user}",
      "gists_url": "https://api.github.com/users/genpfault/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/genpfault/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/genpfault/subscriptions",
      "organizations_url": "https://api.github.com/users/genpfault/orgs",
      "repos_url": "https://api.github.com/users/genpfault/repos",
      "events_url": "https://api.github.com/users/genpfault/events{/privacy}",
      "received_events_url": "https://api.github.com/users/genpfault/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.524628
    },
    {
      "login": "genuinegreg",
      "id": 3304850,
      "node_id": "MDQ6VXNlcjMzMDQ4NTA=",
      "avatar_url": "https://avatars3.githubusercontent.com/u/3304850?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/genuinegreg",
      "html_url": "https://github.com/genuinegreg",
      "followers_url": "https://api.github.com/users/genuinegreg/followers",
      "following_url": "https://api.github.com/users/genuinegreg/following{/other_user}",
      "gists_url": "https://api.github.com/users/genuinegreg/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/genuinegreg/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/genuinegreg/subscriptions",
      "organizations_url": "https://api.github.com/users/genuinegreg/orgs",
      "repos_url": "https://api.github.com/users/genuinegreg/repos",
      "events_url": "https://api.github.com/users/genuinegreg/events{/privacy}",
      "received_events_url": "https://api.github.com/users/genuinegreg/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.45349
    },
    {
      "login": "gentlewind",
      "id": 6801512,
      "node_id": "MDQ6VXNlcjY4MDE1MTI=",
      "avatar_url": "https://avatars0.githubusercontent.com/u/6801512?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/gentlewind",
      "html_url": "https://github.com/gentlewind",
      "followers_url": "https://api.github.com/users/gentlewind/followers",
      "following_url": "https://api.github.com/users/gentlewind/following{/other_user}",
      "gists_url": "https://api.github.com/users/gentlewind/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/gentlewind/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/gentlewind/subscriptions",
      "organizations_url": "https://api.github.com/users/gentlewind/orgs",
      "repos_url": "https://api.github.com/users/gentlewind/repos",
      "events_url": "https://api.github.com/users/gentlewind/events{/privacy}",
      "received_events_url": "https://api.github.com/users/gentlewind/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.374615
    },
    {
      "login": "gensakusiya",
      "id": 4332802,
      "node_id": "MDQ6VXNlcjQzMzI4MDI=",
      "avatar_url": "https://avatars1.githubusercontent.com/u/4332802?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/gensakusiya",
      "html_url": "https://github.com/gensakusiya",
      "followers_url": "https://api.github.com/users/gensakusiya/followers",
      "following_url": "https://api.github.com/users/gensakusiya/following{/other_user}",
      "gists_url": "https://api.github.com/users/gensakusiya/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/gensakusiya/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/gensakusiya/subscriptions",
      "organizations_url": "https://api.github.com/users/gensakusiya/orgs",
      "repos_url": "https://api.github.com/users/gensakusiya/repos",
      "events_url": "https://api.github.com/users/gensakusiya/events{/privacy}",
      "received_events_url": "https://api.github.com/users/gensakusiya/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.368088
    },
    {
      "login": "Gengpp",
      "id": 3023841,
      "node_id": "MDQ6VXNlcjMwMjM4NDE=",
      "avatar_url": "https://avatars2.githubusercontent.com/u/3023841?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/Gengpp",
      "html_url": "https://github.com/Gengpp",
      "followers_url": "https://api.github.com/users/Gengpp/followers",
      "following_url": "https://api.github.com/users/Gengpp/following{/other_user}",
      "gists_url": "https://api.github.com/users/Gengpp/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/Gengpp/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/Gengpp/subscriptions",
      "organizations_url": "https://api.github.com/users/Gengpp/orgs",
      "repos_url": "https://api.github.com/users/Gengpp/repos",
      "events_url": "https://api.github.com/users/Gengpp/events{/privacy}",
      "received_events_url": "https://api.github.com/users/Gengpp/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.350563
    },
    {
      "login": "genilson1-",
      "id": 8923080,
      "node_id": "MDQ6VXNlcjg5MjMwODA=",
      "avatar_url": "https://avatars0.githubusercontent.com/u/8923080?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/genilson1-",
      "html_url": "https://github.com/genilson1-",
      "followers_url": "https://api.github.com/users/genilson1-/followers",
      "following_url": "https://api.github.com/users/genilson1-/following{/other_user}",
      "gists_url": "https://api.github.com/users/genilson1-/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/genilson1-/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/genilson1-/subscriptions",
      "organizations_url": "https://api.github.com/users/genilson1-/orgs",
      "repos_url": "https://api.github.com/users/genilson1-/repos",
      "events_url": "https://api.github.com/users/genilson1-/events{/privacy}",
      "received_events_url": "https://api.github.com/users/genilson1-/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.342827
    },
    {
      "login": "gene7299",
      "id": 10163166,
      "node_id": "MDQ6VXNlcjEwMTYzMTY2",
      "avatar_url": "https://avatars1.githubusercontent.com/u/10163166?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/gene7299",
      "html_url": "https://github.com/gene7299",
      "followers_url": "https://api.github.com/users/gene7299/followers",
      "following_url": "https://api.github.com/users/gene7299/following{/other_user}",
      "gists_url": "https://api.github.com/users/gene7299/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/gene7299/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/gene7299/subscriptions",
      "organizations_url": "https://api.github.com/users/gene7299/orgs",
      "repos_url": "https://api.github.com/users/gene7299/repos",
      "events_url": "https://api.github.com/users/gene7299/events{/privacy}",
      "received_events_url": "https://api.github.com/users/gene7299/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.31834
    },
    {
      "login": "GenesisSam",
      "id": 7623883,
      "node_id": "MDQ6VXNlcjc2MjM4ODM=",
      "avatar_url": "https://avatars0.githubusercontent.com/u/7623883?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/GenesisSam",
      "html_url": "https://github.com/GenesisSam",
      "followers_url": "https://api.github.com/users/GenesisSam/followers",
      "following_url": "https://api.github.com/users/GenesisSam/following{/other_user}",
      "gists_url": "https://api.github.com/users/GenesisSam/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/GenesisSam/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/GenesisSam/subscriptions",
      "organizations_url": "https://api.github.com/users/GenesisSam/orgs",
      "repos_url": "https://api.github.com/users/GenesisSam/repos",
      "events_url": "https://api.github.com/users/GenesisSam/events{/privacy}",
      "received_events_url": "https://api.github.com/users/GenesisSam/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.31362
    },
    {
      "login": "generaldefence",
      "id": 25422630,
      "node_id": "MDQ6VXNlcjI1NDIyNjMw",
      "avatar_url": "https://avatars0.githubusercontent.com/u/25422630?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/generaldefence",
      "html_url": "https://github.com/generaldefence",
      "followers_url": "https://api.github.com/users/generaldefence/followers",
      "following_url": "https://api.github.com/users/generaldefence/following{/other_user}",
      "gists_url": "https://api.github.com/users/generaldefence/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/generaldefence/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/generaldefence/subscriptions",
      "organizations_url": "https://api.github.com/users/generaldefence/orgs",
      "repos_url": "https://api.github.com/users/generaldefence/repos",
      "events_url": "https://api.github.com/users/generaldefence/events{/privacy}",
      "received_events_url": "https://api.github.com/users/generaldefence/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.18594
    },
    {
      "login": "genevera",
      "id": 12733137,
      "node_id": "MDQ6VXNlcjEyNzMzMTM3",
      "avatar_url": "https://avatars3.githubusercontent.com/u/12733137?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/genevera",
      "html_url": "https://github.com/genevera",
      "followers_url": "https://api.github.com/users/genevera/followers",
      "following_url": "https://api.github.com/users/genevera/following{/other_user}",
      "gists_url": "https://api.github.com/users/genevera/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/genevera/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/genevera/subscriptions",
      "organizations_url": "https://api.github.com/users/genevera/orgs",
      "repos_url": "https://api.github.com/users/genevera/repos",
      "events_url": "https://api.github.com/users/genevera/events{/privacy}",
      "received_events_url": "https://api.github.com/users/genevera/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.160946
    },
    {
      "login": "gentoomaniac",
      "id": 4084857,
      "node_id": "MDQ6VXNlcjQwODQ4NTc=",
      "avatar_url": "https://avatars3.githubusercontent.com/u/4084857?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/gentoomaniac",
      "html_url": "https://github.com/gentoomaniac",
      "followers_url": "https://api.github.com/users/gentoomaniac/followers",
      "following_url": "https://api.github.com/users/gentoomaniac/following{/other_user}",
      "gists_url": "https://api.github.com/users/gentoomaniac/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/gentoomaniac/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/gentoomaniac/subscriptions",
      "organizations_url": "https://api.github.com/users/gentoomaniac/orgs",
      "repos_url": "https://api.github.com/users/gentoomaniac/repos",
      "events_url": "https://api.github.com/users/gentoomaniac/events{/privacy}",
      "received_events_url": "https://api.github.com/users/gentoomaniac/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.121025
    },
    {
      "login": "genturwt",
      "id": 9570003,
      "node_id": "MDQ6VXNlcjk1NzAwMDM=",
      "avatar_url": "https://avatars3.githubusercontent.com/u/9570003?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/genturwt",
      "html_url": "https://github.com/genturwt",
      "followers_url": "https://api.github.com/users/genturwt/followers",
      "following_url": "https://api.github.com/users/genturwt/following{/other_user}",
      "gists_url": "https://api.github.com/users/genturwt/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/genturwt/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/genturwt/subscriptions",
      "organizations_url": "https://api.github.com/users/genturwt/orgs",
      "repos_url": "https://api.github.com/users/genturwt/repos",
      "events_url": "https://api.github.com/users/genturwt/events{/privacy}",
      "received_events_url": "https://api.github.com/users/genturwt/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.070934
    },
    {
      "login": "GainLee",
      "id": 2909095,
      "node_id": "MDQ6VXNlcjI5MDkwOTU=",
      "avatar_url": "https://avatars3.githubusercontent.com/u/2909095?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/GainLee",
      "html_url": "https://github.com/GainLee",
      "followers_url": "https://api.github.com/users/GainLee/followers",
      "following_url": "https://api.github.com/users/GainLee/following{/other_user}",
      "gists_url": "https://api.github.com/users/GainLee/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/GainLee/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/GainLee/subscriptions",
      "organizations_url": "https://api.github.com/users/GainLee/orgs",
      "repos_url": "https://api.github.com/users/GainLee/repos",
      "events_url": "https://api.github.com/users/GainLee/events{/privacy}",
      "received_events_url": "https://api.github.com/users/GainLee/received_events",
      "type": "User",
      "site_admin": false,
      "score": 34.048508
    },
    {
      "login": "gengyanlei",
      "id": 22360785,
      "node_id": "MDQ6VXNlcjIyMzYwNzg1",
      "avatar_url": "https://avatars0.githubusercontent.com/u/22360785?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/gengyanlei",
      "html_url": "https://github.com/gengyanlei",
      "followers_url": "https://api.github.com/users/gengyanlei/followers",
      "following_url": "https://api.github.com/users/gengyanlei/following{/other_user}",
      "gists_url": "https://api.github.com/users/gengyanlei/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/gengyanlei/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/gengyanlei/subscriptions",
      "organizations_url": "https://api.github.com/users/gengyanlei/orgs",
      "repos_url": "https://api.github.com/users/gengyanlei/repos",
      "events_url": "https://api.github.com/users/gengyanlei/events{/privacy}",
      "received_events_url": "https://api.github.com/users/gengyanlei/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.981167
    },
    {
      "login": "genneth",
      "id": 221277,
      "node_id": "MDQ6VXNlcjIyMTI3Nw==",
      "avatar_url": "https://avatars3.githubusercontent.com/u/221277?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/genneth",
      "html_url": "https://github.com/genneth",
      "followers_url": "https://api.github.com/users/genneth/followers",
      "following_url": "https://api.github.com/users/genneth/following{/other_user}",
      "gists_url": "https://api.github.com/users/genneth/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/genneth/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/genneth/subscriptions",
      "organizations_url": "https://api.github.com/users/genneth/orgs",
      "repos_url": "https://api.github.com/users/genneth/repos",
      "events_url": "https://api.github.com/users/genneth/events{/privacy}",
      "received_events_url": "https://api.github.com/users/genneth/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.91862
    },
    {
      "login": "geniusyg",
      "id": 6307880,
      "node_id": "MDQ6VXNlcjYzMDc4ODA=",
      "avatar_url": "https://avatars0.githubusercontent.com/u/6307880?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/geniusyg",
      "html_url": "https://github.com/geniusyg",
      "followers_url": "https://api.github.com/users/geniusyg/followers",
      "following_url": "https://api.github.com/users/geniusyg/following{/other_user}",
      "gists_url": "https://api.github.com/users/geniusyg/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/geniusyg/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/geniusyg/subscriptions",
      "organizations_url": "https://api.github.com/users/geniusyg/orgs",
      "repos_url": "https://api.github.com/users/geniusyg/repos",
      "events_url": "https://api.github.com/users/geniusyg/events{/privacy}",
      "received_events_url": "https://api.github.com/users/geniusyg/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.90044
    },
    {
      "login": "Gen2ly",
      "id": 131507,
      "node_id": "MDQ6VXNlcjEzMTUwNw==",
      "avatar_url": "https://avatars1.githubusercontent.com/u/131507?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/Gen2ly",
      "html_url": "https://github.com/Gen2ly",
      "followers_url": "https://api.github.com/users/Gen2ly/followers",
      "following_url": "https://api.github.com/users/Gen2ly/following{/other_user}",
      "gists_url": "https://api.github.com/users/Gen2ly/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/Gen2ly/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/Gen2ly/subscriptions",
      "organizations_url": "https://api.github.com/users/Gen2ly/orgs",
      "repos_url": "https://api.github.com/users/Gen2ly/repos",
      "events_url": "https://api.github.com/users/Gen2ly/events{/privacy}",
      "received_events_url": "https://api.github.com/users/Gen2ly/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.889187
    },
    {
      "login": "GeneTheBean",
      "id": 10777333,
      "node_id": "MDQ6VXNlcjEwNzc3MzMz",
      "avatar_url": "https://avatars1.githubusercontent.com/u/10777333?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/GeneTheBean",
      "html_url": "https://github.com/GeneTheBean",
      "followers_url": "https://api.github.com/users/GeneTheBean/followers",
      "following_url": "https://api.github.com/users/GeneTheBean/following{/other_user}",
      "gists_url": "https://api.github.com/users/GeneTheBean/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/GeneTheBean/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/GeneTheBean/subscriptions",
      "organizations_url": "https://api.github.com/users/GeneTheBean/orgs",
      "repos_url": "https://api.github.com/users/GeneTheBean/repos",
      "events_url": "https://api.github.com/users/GeneTheBean/events{/privacy}",
      "received_events_url": "https://api.github.com/users/GeneTheBean/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.842545
    },
    {
      "login": "Genius1237",
      "id": 15867363,
      "node_id": "MDQ6VXNlcjE1ODY3MzYz",
      "avatar_url": "https://avatars2.githubusercontent.com/u/15867363?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/Genius1237",
      "html_url": "https://github.com/Genius1237",
      "followers_url": "https://api.github.com/users/Genius1237/followers",
      "following_url": "https://api.github.com/users/Genius1237/following{/other_user}",
      "gists_url": "https://api.github.com/users/Genius1237/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/Genius1237/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/Genius1237/subscriptions",
      "organizations_url": "https://api.github.com/users/Genius1237/orgs",
      "repos_url": "https://api.github.com/users/Genius1237/repos",
      "events_url": "https://api.github.com/users/Genius1237/events{/privacy}",
      "received_events_url": "https://api.github.com/users/Genius1237/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.84056
    },
    {
      "login": "genma2612",
      "id": 36157180,
      "node_id": "MDQ6VXNlcjM2MTU3MTgw",
      "avatar_url": "https://avatars2.githubusercontent.com/u/36157180?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/genma2612",
      "html_url": "https://github.com/genma2612",
      "followers_url": "https://api.github.com/users/genma2612/followers",
      "following_url": "https://api.github.com/users/genma2612/following{/other_user}",
      "gists_url": "https://api.github.com/users/genma2612/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/genma2612/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/genma2612/subscriptions",
      "organizations_url": "https://api.github.com/users/genma2612/orgs",
      "repos_url": "https://api.github.com/users/genma2612/repos",
      "events_url": "https://api.github.com/users/genma2612/events{/privacy}",
      "received_events_url": "https://api.github.com/users/genma2612/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.822887
    },
    {
      "login": "Gentle",
      "id": 80344,
      "node_id": "MDQ6VXNlcjgwMzQ0",
      "avatar_url": "https://avatars1.githubusercontent.com/u/80344?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/Gentle",
      "html_url": "https://github.com/Gentle",
      "followers_url": "https://api.github.com/users/Gentle/followers",
      "following_url": "https://api.github.com/users/Gentle/following{/other_user}",
      "gists_url": "https://api.github.com/users/Gentle/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/Gentle/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/Gentle/subscriptions",
      "organizations_url": "https://api.github.com/users/Gentle/orgs",
      "repos_url": "https://api.github.com/users/Gentle/repos",
      "events_url": "https://api.github.com/users/Gentle/events{/privacy}",
      "received_events_url": "https://api.github.com/users/Gentle/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.746468
    },
    {
      "login": "GentleRuan",
      "id": 28596362,
      "node_id": "MDQ6VXNlcjI4NTk2MzYy",
      "avatar_url": "https://avatars2.githubusercontent.com/u/28596362?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/GentleRuan",
      "html_url": "https://github.com/GentleRuan",
      "followers_url": "https://api.github.com/users/GentleRuan/followers",
      "following_url": "https://api.github.com/users/GentleRuan/following{/other_user}",
      "gists_url": "https://api.github.com/users/GentleRuan/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/GentleRuan/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/GentleRuan/subscriptions",
      "organizations_url": "https://api.github.com/users/GentleRuan/orgs",
      "repos_url": "https://api.github.com/users/GentleRuan/repos",
      "events_url": "https://api.github.com/users/GentleRuan/events{/privacy}",
      "received_events_url": "https://api.github.com/users/GentleRuan/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.73919
    },
    {
      "login": "gentlebreeza",
      "id": 8635242,
      "node_id": "MDQ6VXNlcjg2MzUyNDI=",
      "avatar_url": "https://avatars3.githubusercontent.com/u/8635242?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/gentlebreeza",
      "html_url": "https://github.com/gentlebreeza",
      "followers_url": "https://api.github.com/users/gentlebreeza/followers",
      "following_url": "https://api.github.com/users/gentlebreeza/following{/other_user}",
      "gists_url": "https://api.github.com/users/gentlebreeza/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/gentlebreeza/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/gentlebreeza/subscriptions",
      "organizations_url": "https://api.github.com/users/gentlebreeza/orgs",
      "repos_url": "https://api.github.com/users/gentlebreeza/repos",
      "events_url": "https://api.github.com/users/gentlebreeza/events{/privacy}",
      "received_events_url": "https://api.github.com/users/gentlebreeza/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.72988
    },
    {
      "login": "GenjiOnly",
      "id": 25947923,
      "node_id": "MDQ6VXNlcjI1OTQ3OTIz",
      "avatar_url": "https://avatars2.githubusercontent.com/u/25947923?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/GenjiOnly",
      "html_url": "https://github.com/GenjiOnly",
      "followers_url": "https://api.github.com/users/GenjiOnly/followers",
      "following_url": "https://api.github.com/users/GenjiOnly/following{/other_user}",
      "gists_url": "https://api.github.com/users/GenjiOnly/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/GenjiOnly/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/GenjiOnly/subscriptions",
      "organizations_url": "https://api.github.com/users/GenjiOnly/orgs",
      "repos_url": "https://api.github.com/users/GenjiOnly/repos",
      "events_url": "https://api.github.com/users/GenjiOnly/events{/privacy}",
      "received_events_url": "https://api.github.com/users/GenjiOnly/received_events",
      "type": "User",
      "site_admin": false,
      "score": 33.71959
    }
  ]
}
""".trimIndent()