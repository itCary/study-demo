package online.goudan.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/23 16:43
 */
@Data
@Table(name = "tb_user")
public class TbUser {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private String name;

    private Integer age;
    //1.男 2.女
    private Integer sex;

    private Date birthday;

    private String note;
    private Date created;

}
