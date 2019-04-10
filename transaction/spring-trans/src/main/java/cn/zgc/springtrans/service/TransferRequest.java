package cn.zgc.springtrans.service;

public class TransferRequest {
    private String outAcctName;
    private String inAcctName;
    private long balance;


    public TransferRequest(String outAcctName, String inAcctName, long balance) {
        this.outAcctName = outAcctName;
        this.inAcctName = inAcctName;
        this.balance = balance;
    }

    public String getOutAcctName() {
        return outAcctName;
    }

    public void setOutAcctName(String outAcctName) {
        this.outAcctName = outAcctName;
    }

    public String getInAcctName() {
        return inAcctName;
    }

    public void setInAcctName(String inAcctName) {
        this.inAcctName = inAcctName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                "outAcctName='" + outAcctName + '\'' +
                ", inAcctName='" + inAcctName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
