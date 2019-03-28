package cn.zgc.springtrans.mapper.domain;

public class Acct {
    private String id;
    private String acctName;
    private long balance;

    public Acct(String acctName, long balance) {
        this.acctName = acctName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Acct{" +
                "id='" + id + '\'' +
                ", acctName='" + acctName + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
