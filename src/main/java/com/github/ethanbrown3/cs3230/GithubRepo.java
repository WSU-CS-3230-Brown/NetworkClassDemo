package com.github.ethanbrown3.cs3230;

public class GithubRepo {
    public long id;
    public String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String html_url;

    @Override
    public String toString() {
        return "GithubRepo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", html_url='" + html_url + '\'' +
                '}';
    }
}
