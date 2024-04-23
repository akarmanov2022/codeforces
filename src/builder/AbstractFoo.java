package builder;

/**
 * @author Arseniy Karmanov
 */
public abstract class AbstractFoo {
    private String field1;
    private String field2;
    private String field3;

    abstract static class Builder<T extends Builder<T>> {
        private final String field1;
        private String field2;
        private String field3;

        public Builder(String field1) {
            this.field1 = field1;
        }

        public T field2(String field2) {
            this.field2 = field2;
            return self();
        }
        public T field3(String field3) {
            this.field3 = field3;
            return self();
        }

        protected abstract T self();

        public abstract AbstractFoo build();
    }

    AbstractFoo(Builder<?> builder) {
        this.field1 = builder.field1;
        this.field2 = builder.field2;
        this.field3 = builder.field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
