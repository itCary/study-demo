package online.goudan.utils;

public abstract class MailParam {
    public Param PROTOCOL;
    public Param HOST;
    public Param PORT;
    public Param AUTH;


    public class Param {
        private String paramName;
        private String paramValue;
        private String paramDesc;

        public Param(String paramName, String paramValue, String paramDesc) {
            this.paramName = paramName;
            this.paramValue = paramValue;
            this.paramDesc = paramDesc;
        }

        public String getParamName() {
            return paramName;
        }

        public String getParamValue() {
            return paramValue;
        }
    }
}
