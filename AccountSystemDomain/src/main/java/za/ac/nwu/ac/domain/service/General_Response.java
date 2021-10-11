package za.ac.nwu.ac.domain.service;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<T> implements Serializable {

    private static final long serialVersionUID = -2109552313657529496L;

    private final boolean successsful;
    private final transient T payload;

    public GeneralResponse(boolean successsfull, T payload){
        this.successsful = successsfull;
        this.payload = payload;
    }

    public boolean isSuccesssfull(){return successsful;}

    public T getPayload(){return payload;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return successsful == that.successsful && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {return Objects.hash(successsful, payload); }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "successsfull=" + successsful +
                ", payload=" + payload +
                '}';
    }
}