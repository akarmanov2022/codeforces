package builder;

/**
 * @author Arseniy Karmanov
 */
public class Foo1 extends AbstractFoo {
    private String bar1;
    private String bar2;
    private String bar3;

    public static class Foo1Builder extends AbstractFoo.Builder<Foo1Builder> {
        private String bar1;
        private String bar2;
        private String bar3;

        public Foo1Builder(String field1) {
            super(field1);
        }

        public Foo1Builder bar1(String bar1) {
            this.bar1 = bar1;
            return this;
        }

        public Foo1Builder bar2(String bar2) {
            this.bar2 = bar2;
            return this;
        }

        @Override
        protected Foo1Builder self() {
            return this;
        }

        @Override
        public Foo1 build() {
            return new Foo1(this);
        }
    }

    Foo1(Foo1Builder builder) {
        super(builder);
        this.bar1 = builder.bar1;
        this.bar2 = builder.bar2;
        this.bar3 = builder.bar3;
    }

    public String getBar1() {
        return bar1;
    }

    public void setBar1(String bar1) {
        this.bar1 = bar1;
    }

    public String getBar2() {
        return bar2;
    }

    public void setBar2(String bar2) {
        this.bar2 = bar2;
    }

    public String getBar3() {
        return bar3;
    }

    public void setBar3(String bar3) {
        this.bar3 = bar3;
    }
}
