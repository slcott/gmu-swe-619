package edu.gmu.swe619.queue;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableQueue<E> {
   private final List<E> elements;
   private final int size;

   public ImmutableQueue() {   
      this.elements = List.of();
      this.size = 0;
   }

   private ImmutableQueue(List<E> elements) {
      this.elements = List.copyOf(elements);
      this.size = elements.size();
   }

   public ImmutableQueue<E> enQueue(E e) {
      if (e == null) throw new NullPointerException("ImmutableQueue.enQueue");
      List<E> newList = new ArrayList<>(this.elements);
      newList.add(e);
      return new ImmutableQueue<E>(newList);
   }

   // deQueue becomes getFirst() as Observer and deQueue() as Producer,
   // since deQueue() now returns a new list
   // instead of the first item in the queue.
   public E getFirst() {
      if (size == 0) {
         throw new IllegalStateException("ImmutableQueue.getFirst");
      }
      return elements.get(0);
   }

   public ImmutableQueue<E> deQueue() {
      if (size == 0) {
         throw new IllegalStateException("ImmutableQueue.deQueue");
      }
      List<E> newElements = new ArrayList<>(elements.subList(1, size));
      return new ImmutableQueue<>(newElements);
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public static void main(String[] args) {
      // Simple exercise to enQueue/deQueue cmd line args
      // Usage:  java ImmutableQueue item1 item2 item3 ...
      ImmutableQueue<String> q = new ImmutableQueue<String>();
      for (String arg : args) {
         q = q.enQueue(arg);
      }
      while (!q.isEmpty() ) {
         System.out.println(q.getFirst());
         q = q.deQueue();
      }
   }
}
