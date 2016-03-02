package com.concur.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

/**
 * Created by PrakashV on 1/27/2016.
 */
public class ArchiveRun {

    public ArchiveRun()
    {
    }

    @NotEmpty
    @Column(name = "job_key")
    private int jobKey;

    @NotEmpty
    @Column(name = "job_status")
    private String jobStatus;

    @NotEmpty
    @Column(name = "job_duration")
    private long jobDuration;

    public int getJobKey() {
        return jobKey;
    }

    public void setJobKey(int jobKey) {
        this.jobKey = jobKey;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public long getJobDuration() {
        return jobDuration;
    }

    public void setJobDuration(long jobDuration) {
        this.jobDuration = jobDuration;
    }
}
