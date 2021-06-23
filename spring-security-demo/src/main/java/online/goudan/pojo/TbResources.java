package online.goudan.pojo;

import lombok.Data;

import java.util.List;

@Data
public class TbResources {
    private Long id;

    private String url;

    private String desc;

    private List<TbRole> roleList;

}