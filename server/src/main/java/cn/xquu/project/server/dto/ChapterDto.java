package cn.xquu.project.server.dto;

public class ChapterDto {
    private String id;

    private String coutseId;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoutseId() {
        return coutseId;
    }

    public void setCoutseId(String coutseId) {
        this.coutseId = coutseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", coutseId=").append(coutseId);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}