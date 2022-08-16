## Let Me Update

### Features
- Users can signup to create accounts
   - Users have username, email, bio (text), avatar (img url)
- Users can login to their accounts
- Users can write blog articles
  - Blog articles should have a heading, subheading, tags and content body
  - Assume reasonable length for heading, subheading, no limit on body
  - Body content will be html
  - Tags are an array of strings
  - Users can delete articles they have created
  - Users can update articles they have created
- Users can comment on blog articles
  - Comments will have a title and a body
  - Title is optional, but body is required
  - Users can delete comments they have created
- Users can like blog articles
- Users can follow other users
- Users can see list of all other users
  - Users can see profile of individual users
  - Users can search for profiles by username (or part)
- There should be a feed of all articles (reverse chronological order)
  - Ability to filter blogs by tags
  - Ability to filter blogs written by a specific user
  - Ability to search for articles by title
  - Ability to sort articles by [date (default), likes]
- There should be a feed of all articles of authors a user is following

### Future Scope
- Add a image upload service so that \<img\> can be embedded in blog articles
- Add support for pagination when listing articles and users


### Technical Specification

#### Entities

##### User
```json
  {
  "id": 12,
  "username":"IShahnawazShaikh",
  "email":"shahnawaz@gmail.com",
  "avatar": "https://avatars.dicebear.com/v2/johndoe001.png",
  "createdAt": "2020-01-01T00:00:00.000Z"
 }
```
##### Article

```json
{
  "id": 124,
  "heading": "My first blog post",
  "slug": "my-first-blog-post",
  "subheading": "This is my first blog post",
  "tags": ["blog", "first"],
  "content": "<p>This is my first blog post</p>",
  "authorId": 12,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```

##### Comment

```json
{
  "id": 17,
  "title": "My first comment",
  "body": "This is my first comment",
  "articleId": 124,
  "authorId": 42,
  "createdAt": "2020-01-01T00:00:00.000Z"
}

```


### Join Tables

#### Follows
```json
{
  "id": 133,
  "followerId": 12,
  "followeeId": 42,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```

##### Likes

```json
{
  "id": 524,
  "likerId": 12,
  "articleId": 124,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```

### Schema Diagram

![image](https://user-images.githubusercontent.com/1327050/168328390-12badd31-49f9-4a00-a3be-b94f7298e4fc.png)


