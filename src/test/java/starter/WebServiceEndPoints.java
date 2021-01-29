package starter;

public enum WebServiceEndPoints {
    USERS("https://jsonplaceholder.typicode.com/users"),
    POSTS("https://jsonplaceholder.typicode.com/posts"),
    COMMENTS("https://jsonplaceholder.typicode.com/comments");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
