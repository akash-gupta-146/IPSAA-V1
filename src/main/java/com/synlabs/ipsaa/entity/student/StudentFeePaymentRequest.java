package com.synlabs.ipsaa.entity.student;

import com.synlabs.ipsaa.entity.common.BaseEntity;
import com.synlabs.ipsaa.enums.FeeDuration;
import com.synlabs.ipsaa.enums.PaymentStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class StudentFeePaymentRequest extends BaseEntity
{
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Student student;

  private int month;

  private int quarter;

  private int year;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "request", cascade = CascadeType.ALL)
  @OrderBy("paymentDate DESC")
  private List<StudentFeePaymentRecord> payments = new ArrayList<>();

  @Column(unique = true, length = 20)
  private String slipSerial;

  @Column(unique = true, length = 200)
  private String slipFileName;

  @Column(unique = true, length = 20)
  private String receiptSerial;

  @Column(unique = true, length = 200)
  private String receiptFileName;

  @Column(precision = 16, scale = 2, nullable = false)
  private BigDecimal baseFee;

  @Column(precision = 16, scale = 2)
  private BigDecimal extraCharge;

  @Column(precision = 16, scale = 2)
  private BigDecimal latePaymentCharge;

  @Column(precision = 16, scale = 2, nullable = false)
  private BigDecimal totalFee;

  @Temporal(TemporalType.DATE)
  private Date invoiceDate;

  @Column(precision = 16, scale = 2)
  private BigDecimal deposit;

  @Column(precision = 16, scale = 2)
  private BigDecimal annualFee;

  @Column(precision = 16, scale = 2)
  private BigDecimal adjust;

  @Enumerated(EnumType.STRING)
  private FeeDuration feeDuration;

  @Column(length = 200)
  private String comments;

  @Column(length = 200)
  private String autoComments;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private PaymentStatus paymentStatus;

  @Column(unique = true)
  private String tnxid;

  private boolean reGenerateSlip = true;

  @Column(precision = 16, scale = 2)
  private BigDecimal sgst;

  @Column(precision = 16, scale = 2)
  private BigDecimal cgst;

  @Column(precision = 16, scale = 2)
  private BigDecimal igst;
  
  @Column(columnDefinition = "bit(1) default 0")
  private boolean generateActive = false;

  public boolean isGenerateActive() {
	return generateActive;
}

public void setGenerateActive(boolean generateActive) {
	this.generateActive = generateActive;
}

private BigDecimal balance;

  public BigDecimal getAdjust()
  {
    return adjust;
  }

  public void setAdjust(BigDecimal adjust)
  {
    this.adjust = adjust;
  }

  public String getAutoComments()
  {
    return autoComments;
  }

  public void setAutoComments(String autoComments)
  {
    this.autoComments = autoComments;
  }

  public BigDecimal getBalance()
  {
    return balance;
  }

  public void setBalance(BigDecimal balance)
  {
    this.balance = balance;
  }

  public BigDecimal getIgst()
  {
    return igst;
  }

  public void setIgst(BigDecimal igst)
  {
    this.igst = igst;
  }

  public BigDecimal getSgst()
  {
    return sgst;
  }

  public void setSgst(BigDecimal sgst)
  {
    this.sgst = sgst;
  }

  public BigDecimal getCgst()
  {
    return cgst;
  }

  public void setCgst(BigDecimal cgst)
  {
    this.cgst = cgst;
  }

  public String getTnxid()
  {
    return tnxid;
  }

  public void setTnxid(String tnxid)
  {
    this.tnxid = tnxid;
  }

  public String getSlipFileName()
  {
    return slipFileName;
  }

  public void setSlipFileName(String slipFileName)
  {
    this.slipFileName = slipFileName;
  }

  public BigDecimal getDeposit()
  {
    return deposit;
  }

  public void setDeposit(BigDecimal deposit)
  {
    this.deposit = deposit;
  }

  public BigDecimal getAnnualFee()
  {
    return annualFee;
  }

  public void setAnnualFee(BigDecimal annualFee)
  {
    this.annualFee = annualFee;
  }

  public String getSlipSerial()
  {
    return slipSerial;
  }

  public void setSlipSerial(String slipSerial)
  {
    this.slipSerial = slipSerial;
  }

  public boolean isReGenerateSlip()
  {
    return reGenerateSlip;
  }

  public void setReGenerateSlip(boolean reGenerateSlip)
  {
    this.reGenerateSlip = reGenerateSlip;
  }

  public int getQuarter()
  {
    return quarter;
  }

  public void setQuarter(int quarter)
  {
    this.quarter = quarter;
  }

  public FeeDuration getFeeDuration()
  {
    return feeDuration;
  }

  public void setFeeDuration(FeeDuration feeDuration)
  {
    this.feeDuration = feeDuration;
  }

  public Student getStudent()
  {
    return student;
  }

  public void setStudent(Student student)
  {
    this.student = student;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public BigDecimal getBaseFee()
  {
    return baseFee;
  }

  public void setBaseFee(BigDecimal baseFee)
  {
    this.baseFee = baseFee;
  }

  public BigDecimal getExtraCharge()
  {
    return extraCharge;
  }

  public void setExtraCharge(BigDecimal extraCharge)
  {
    this.extraCharge = extraCharge;
  }

  public BigDecimal getLatePaymentCharge()
  {
    return latePaymentCharge;
  }

  public void setLatePaymentCharge(BigDecimal latePaymentCharge)
  {
    this.latePaymentCharge = latePaymentCharge;
  }

  public BigDecimal getTotalFee()
  {
    return totalFee;
  }

  public void setTotalFee(BigDecimal totalFee)
  {
    this.totalFee = totalFee;
  }

  public Date getInvoiceDate()
  {
    return invoiceDate;
  }

  public void setInvoiceDate(Date invoiceDate)
  {
    this.invoiceDate = invoiceDate;
  }

  public String getComments()
  {
    return comments;
  }

  public void setComments(String comments)
  {
    this.comments = comments;
  }

  public PaymentStatus getPaymentStatus()
  {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus)
  {
    this.paymentStatus = paymentStatus;
  }

  public List<StudentFeePaymentRecord> getPayments()
  {
    return payments;
  }

  public void setPayments(List<StudentFeePaymentRecord> payments)
  {
    this.payments = payments;
  }

  public void addPayment(StudentFeePaymentRecord payment) {
    this.payments.add(payment);
  }

  public String getReceiptSerial()
  {
    return receiptSerial;
  }

  public void setReceiptSerial(String receiptSerial)
  {
    this.receiptSerial = receiptSerial;
  }

  public String getReceiptFileName()
  {
    return receiptFileName;
  }

  public void setReceiptFileName(String receiptFileName)
  {
    this.receiptFileName = receiptFileName;
  }

  @Transient
  public BigDecimal getPaidAmount()
  {
    BigDecimal paidAmount = BigDecimal.ZERO;
    for (StudentFeePaymentRecord payment : payments)
    {
      if (payment.getPaymentStatus() == PaymentStatus.Paid
          || payment.getPaymentStatus() == PaymentStatus.PartiallyPaid)
      {
        paidAmount = paidAmount.add(payment.getPaidAmount());
      }
    }
    return paidAmount;
  }
}
