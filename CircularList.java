class CircularList<Type> {

  private Node<Type> head = null;
  private Node<Type> tail = null;
  private int listSize;
  private Node currentIndex;

  //////////////////////////////////////////////////////////

  public CircularList(){
    this.listSize = 0;
  }

  //////////////////////////////////////////////////////////

  public void addElement(Type data){

    Node<Type> element = new Node<Type>(data);
    Node tmp;

    if(this.listSize == 0){
      this.head = element;
      this.tail = this.head;
      this.head.next = this.tail;
    }
    else{
      tmp = this.head;
      this.head = element;
      element.next = tmp;
    }
    this.updateAttributes();
    this.listSize++;
  }

  ///////////////////////////////////////////////////////////

  public void deleteLast(){
    if(this.listSize != 0) {
      this.head = this.head.next;
      this.updateAttributes();
      this.listSize--;
    }
  }

  //////////////////////////////////////////////////////////

  public void deleteItem(int position){
    if(this.listSize != 0) {
      Node tmp = this.head;
      for (int i=1; i<position-1; i++) {
        tmp = tmp.next;
      }
      tmp.next = tmp.next.next;
      this.listSize--;
    }
  }

  //////////////////////////////////////////////////////////

  private void updateAttributes(){
    this.tail.next = this.head;
    this.currentIndex = this.head;
  }

  /////////////////////////////////////////////////////////

  public void printAll(){
    if(this.listSize != 0) {
      Node tmp = this.head;
      for (int i=0; i<this.listSize; i++) {
        System.out.println(tmp.data);
        tmp = tmp.next;
      }
    }
  }

  ////////////////////////////////////////////////////////

  public void printNext(){
    if(this.listSize != 0) {
      System.out.println(this.currentIndex.data);
      this.currentIndex = this.currentIndex.next;  
    }
  }

}
