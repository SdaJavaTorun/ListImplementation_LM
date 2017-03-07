package com.sdajava.listimpl;

/**
 * Created by lukas on 06.03.2017.
 */
class ListImpl{

    private Node start;
    private Node stop;

    public ListImpl(){
        this.start = null;
        this.stop = null;
    }

    public void addElement(String value){

        Node node = new Node(value, null, null);
        //tworzenie nowego elementu

        if(checkIsEmpty()){
            start = node;
            stop = node;
        }
        else{
            Node pm = start;

            while (pm != null){
                pm.getNext();

                if(pm == start){
                    node.setNext(pm);
                    pm.setPrev(node);
                    start = node;
                    break;
                }else {
                    node.setNext(pm);
                    node.setPrev(pm.getPrev());
                    pm.getPrev().setPrev(node);
                    pm.setPrev(node);
                    break;
                }
            }
            if(pm == null){
                stop.setNext(node);
                node.setPrev(stop);
                stop = node;
            }
        }

    }
    public boolean checkIsEmpty(){
        return (start == null);
    }
}
