package online.goudan.pojo;

import java.util.List;

/**
 * @author chenglongliu
 * @date 2020/12/21 14:42
 * @desc 响应数据的封装
 */
@lombok.NoArgsConstructor
@lombok.Data
public class ReponsePojo<T> {

    /**
     * id : 1
     * others : {"max_rules":80}
     * result : [{"ac_mac_id":"0","txt_macf_info":"研发-刘成龙","txt_mac_addr":"38-F9-D3-37-49-FD"}]
     * error_code : 0
     */

    @com.fasterxml.jackson.annotation.JsonProperty("id")
    private Integer id;
    @com.fasterxml.jackson.annotation.JsonProperty("others")
    private OthersDTO others;
    @com.fasterxml.jackson.annotation.JsonProperty("error_code")
    private String errorCode;
    @com.fasterxml.jackson.annotation.JsonProperty("result")
    private List<T> result;

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class OthersDTO {
        /**
         * max_rules : 80
         */

        @com.fasterxml.jackson.annotation.JsonProperty("max_rules")
        private Integer maxRules;
    }

}
